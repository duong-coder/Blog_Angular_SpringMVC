import { Injectable, INJECTOR } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from './../../environments/environment';


import {POST} from '../model/data-post';
import { DateService } from './date.service';
import { Post } from '../model/post';
import { Account } from '../model/account';

@Injectable()
export class PostService{
    private URL_GET_ACCOUNT: string = '/api/account/0773314448';
    // private URL_GET_ACCOUNT: string = environment.apiUrl + '/api/account/0773314448';
    private URL_GET_POST_BY_ID: string = '/api/post/';
    private URL_INSERT_PUT_POST: string = '/api/post';
    
    constructor(
        private dateService: DateService,
        private http: HttpClient
    ){}
    getAllPost(): Observable<Account>{
        console.log("GET_ACCOUNT");

        return this.http.get<Account>(this.URL_GET_ACCOUNT);
    }
    getPostById(id: number): Observable<Post>{
        return this.http.get<Post>(this.URL_GET_POST_BY_ID + id);
    }
    addPost(post: Post): Observable<Post>{
        const httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json'})
        };
        return this.http.post<Post>(this.URL_INSERT_PUT_POST, post, httpOptions);
    }
    updatePost(post: Post): Observable<Post>{
        const httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json'})
        };
        return this.http.put<Post>(this.URL_INSERT_PUT_POST, post, httpOptions);
    }
    deletePost(id: number): void{
        const index = POST.findIndex(p => {
            return p.id === id;
        });
        POST.splice(index, 1);
    }
}
