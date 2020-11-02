import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutPageComponent } from './about-page/about-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NewPostPageComponent } from './new-post-page/new-post-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PostDetailPageComponent } from './post-detail-page/post-detail-page.component';

const routes: Routes = [
  {path: 'home', component: HomePageComponent},
  {path: 'about', component: AboutPageComponent},
  {path: 'new-post', component: NewPostPageComponent},
  {path: 'post/:id', component: PostDetailPageComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
