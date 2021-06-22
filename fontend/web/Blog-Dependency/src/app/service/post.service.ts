import { Injectable, INJECTOR } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from './../../environments/environment';


import {POST} from '../model/data-post';
import { DateService } from './date.service';
import { Post } from '../model/post';
import { Account } from '../model/account';
import { JwttokenService } from './jwttoken.service';
import { ResponseEnity } from '../model/response-entity';

@Injectable()
export class PostService{
    private URL_GET_ALL_POST = '/api/post/all/duongnh';
    // private URL_GET_ALL_POST: string = environment.apiUrl + '/api/account/0773314448';
    private URL_GET_POST_BY_ID = '/api/post/';
    private URL_INSERT_PUT_POST = '/api/post';
    private URL_DELETE_POST_BY_ID = '/api/post/';

    constructor(
        private dateService: DateService,
        private http: HttpClient,
        private jwttokenService: JwttokenService
    ){}
    getAllPost(): Observable<ResponseEnity<Post[]>>{
        console.log('GET_ALL_POST');
        return this.http.get<ResponseEnity<Post[]>>(this.URL_GET_ALL_POST);
    }
    getPostById(id: number): Observable<ResponseEnity<Post>>{
        return this.http.get<ResponseEnity<Post>>(this.URL_GET_POST_BY_ID + id);
    }
    addPost(post: Post): Observable<ResponseEnity<Post>>{
        return this.http.post<ResponseEnity<Post>>(this.URL_INSERT_PUT_POST, post);
    }
    updatePost(post: Post): Observable<ResponseEnity<Post>>{
        return this.http.put<ResponseEnity<Post>>(this.URL_INSERT_PUT_POST, post);
    }
    deletePost(id: number): Observable<ResponseEnity<Post>>{
        return this.http.delete<ResponseEnity<Post>>(this.URL_DELETE_POST_BY_ID + id);
    }
}
