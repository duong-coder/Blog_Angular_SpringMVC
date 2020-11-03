import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BodyComponent } from './body/body.component';
import { PostComponent } from './post-title/post.component';
import { FormPostComponent } from './form-post/form-post.component';
import { HeaderComponent } from './header/header.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { FlagAcountComponent } from './flag-acount/flag-acount.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { NewPostPageComponent } from './new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './post-detail-page/post-detail-page.component';

import {PostService} from './post.service';
import { EditPostPageComponent } from './edit-post-page/edit-post-page.component';


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
    FontAwesomeModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
