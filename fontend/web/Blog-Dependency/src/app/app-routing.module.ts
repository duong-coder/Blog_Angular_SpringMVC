import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './page/login/login.component';
import { AboutPageComponent } from './page/about-page/about-page.component';
import { EditPostPageComponent } from './page/edit-post-page/edit-post-page.component';
import { HomePageComponent } from './page/home-page/home-page.component';
import { NewPostPageComponent } from './page/new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './page/post-detail-page/post-detail-page.component';
import { DefaultComponent } from './layouts/default/default.component';
import { AmendPostComponent } from './layouts/amend-post/amend-post.component';

const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
    children: [
      { path: 'home', component: HomePageComponent },
      { path: 'about', component: AboutPageComponent },
      { path: 'post/detail/:id', component: PostDetailPageComponent },
    ]
  },
  {
    path: 'post',
    component: AmendPostComponent,
    children: [
      { path: 'new', component: NewPostPageComponent },
      { path: 'edit/:id', component: EditPostPageComponent },
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
