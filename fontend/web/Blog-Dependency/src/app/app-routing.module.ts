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
import { EditAboutPageComponent } from './page/edit-about-page/edit-about-page.component';
import { AuthGuard } from './interceptors/auth.guard';

const routes: Routes = [
  {
    path: 'duongnh',
    children: [
      {
        path: '',
        component: DefaultComponent,
        children: [
          { path: 'home', component: HomePageComponent },
          { path: 'about', component: AboutPageComponent },
          { path: 'about/edit', component: EditAboutPageComponent, canActivate: [AuthGuard] },
          { path: 'post/detail/:id', component: PostDetailPageComponent },
          { path: '', redirectTo: 'home', pathMatch: 'full'},
        ]
      },
      {
        path: 'post',
        component: AmendPostComponent,
        children: [
          { path: 'new', component: NewPostPageComponent },
          { path: 'edit/:id', component: EditPostPageComponent },
        ],
        canActivate: [AuthGuard]
      }
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'duongnh', pathMatch: 'full'},
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
