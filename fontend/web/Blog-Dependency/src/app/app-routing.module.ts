import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './common/login/login.component';
import { AboutPageComponent } from './page/about-page/about-page.component';
import { EditPostPageComponent } from './page/edit-post-page/edit-post-page.component';
import { HomePageComponent } from './page/home-page/home-page.component';
import { NewPostPageComponent } from './page/new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page/page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './page/post-detail-page/post-detail-page.component';

const routes: Routes = [
  {path: 'home', component: HomePageComponent},
  {path: 'about', component: AboutPageComponent},
  {path: 'new-post', component: NewPostPageComponent},
  {path: 'post/:id', component: PostDetailPageComponent},
  {path: 'edit/:id', component: EditPostPageComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
