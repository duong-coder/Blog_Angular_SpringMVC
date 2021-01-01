import { BrowserModule } from '@angular/platform-browser';
import { NgModule, SecurityContext } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MarkdownModule, MarkdownService, MarkedOptions } from 'ngx-markdown';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './common/navbar/navbar.component';
import { FooterComponent } from './common/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BodyComponent } from './common/body/body.component';
import { PostComponent } from './common/post-title/post.component';
import { FormPostComponent } from './common/form-post/form-post.component';
import { HeaderComponent } from './common/header/header.component';
import { PostDetailComponent } from './common/post-detail/post-detail.component';
import { FlagAcountComponent } from './common/flag-acount/flag-acount.component';
import { LoginComponent } from './common/login/login.component';
import { HomePageComponent } from './page/home-page/home-page.component';
import { AboutPageComponent } from './page/about-page/about-page.component';
import { NewPostPageComponent } from './page/new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './page/post-detail-page/post-detail-page.component';
import { EditPostPageComponent } from './page/edit-post-page/edit-post-page.component';

import { PostService } from './service/post.service';
import { DateService } from './service/date.service';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    BodyComponent,
    PostComponent,
    FormPostComponent,
    HeaderComponent,
    PostDetailComponent,
    FlagAcountComponent,
    LoginComponent,
    HomePageComponent,
    AboutPageComponent,
    NewPostPageComponent,
    PageNotFoundComponent,
    PostDetailPageComponent,
    EditPostPageComponent
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
    })
  ],
  providers: [PostService, DateService, MarkdownService],
  bootstrap: [AppComponent]
})
export class AppModule { }
