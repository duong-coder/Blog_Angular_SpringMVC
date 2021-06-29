import { BrowserModule } from '@angular/platform-browser';
import { NgModule, SecurityContext } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MarkdownModule, MarkdownService, MarkedOptions } from 'ngx-markdown';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './common/navbar/navbar.component';
import { FooterComponent } from './common/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HeaderComponent } from './common/header/header.component';
import { FlagAcountComponent } from './common/flag-acount/flag-acount.component';
import { LoginComponent } from './page/login/login.component';
import { HomePageComponent } from './page/home-page/home-page.component';
import { AboutPageComponent } from './page/about-page/about-page.component';
import { NewPostPageComponent } from './page/new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './page/post-detail-page/post-detail-page.component';
import { EditPostPageComponent } from './page/edit-post-page/edit-post-page.component';

import { PostService } from './service/post.service';
import { DateService } from './service/date.service';
import { DefaultComponent } from './layouts/default/default.component';
import { PostListComponent } from './modules/posts/post-list/post-list.component';
import { PostAddComponent } from './modules/posts/post-add/post-add.component';
import { PostDetailComponent } from './modules/posts/post-detail/post-detail.component';
import { AmendPostComponent } from './layouts/amend-post/amend-post.component';
import { HttpTokenInterceptor } from './interceptors/http.token.interceptor';
import { ProfileDetailComponent } from './modules/profile/profile-detail/profile-detail.component';
import { ProfileEditComponent } from './modules/profile/profile-edit/profile-edit.component';
import { ProfileContentComponent } from './modules/profile/profile-content/profile-content.component';
import { ProfileTimelineComponent } from './modules/profile/profile-detail/profile-timeline/profile-timeline.component';
import { ProfileTimeItemComponent } from './modules/profile/profile-detail/profile-time-item/profile-time-item.component';
import { ProfileControlEditComponent } from './modules/profile/profile-edit/profile-control-edit/profile-control-edit.component';
import { EditAboutPageComponent } from './page/edit-about-page/edit-about-page.component';
import { ProfileTimeItemEditComponent } from './modules/profile/profile-edit/profile-time-item-edit/profile-time-item-edit.component';
import { ProfileTimelineEditComponent } from './modules/profile/profile-edit/profile-timeline-edit/profile-timeline-edit.component';
import { StarRatingComponent } from './common/star-rating/star-rating.component';
import { ModalService } from './service/modal.service';
import { SkillEditComponent } from './modules/profile/profile-edit/skill-edit/skill-edit.component';
import { ErrorInterceptor } from './interceptors/error.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HeaderComponent,
    FlagAcountComponent,
    LoginComponent,
    HomePageComponent,
    AboutPageComponent,
    NewPostPageComponent,
    PageNotFoundComponent,
    PostDetailPageComponent,
    EditPostPageComponent,
    DefaultComponent,
    PostListComponent,
    PostAddComponent,
    PostDetailComponent,
    AmendPostComponent,
    ProfileDetailComponent,
    ProfileEditComponent,
    ProfileContentComponent,
    ProfileTimelineComponent,
    ProfileTimeItemComponent,
    ProfileControlEditComponent,
    EditAboutPageComponent,
    ProfileTimeItemEditComponent,
    ProfileTimelineEditComponent,
    StarRatingComponent,
    SkillEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    HttpClientModule,
    MarkdownModule.forRoot({
      sanitize: SecurityContext.NONE,
      loader: HttpClient, // optional, only if you use [src] attribute
      markedOptions: {
        provide: MarkedOptions,
        useValue: {
          gfm: true,
          breaks: false,
          pedantic: false,
          smartLists: true,
          smartypants: false,
        },
      },
    }),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpTokenInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    PostService,
    DateService,
    MarkdownService],
  bootstrap: [AppComponent],
  entryComponents: [ProfileControlEditComponent]
})
export class AppModule { }
