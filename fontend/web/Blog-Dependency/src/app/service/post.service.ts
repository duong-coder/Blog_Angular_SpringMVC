import { Injectable, INJECTOR } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from './../../environments/environment';


import {POST} from '../model/data-post';
import { DateService } from './date.service';
import { Post } from '../model/post';
import { Account } from '../model/account';

@Injectable()
export class PostService{
    // private URL_GET_ACCOUNT: string = '/api/account/0773314448';
    private URL_GET_ACCOUNT: string = environment.apiUrl + '/api/account/0773314448';
    constructor(
        private dateService: DateService,
        private http: HttpClient
    ){}
    getAllPost(): Observable<Account>{
        console.log("GET_ACCOUNT");

        return this.http.get<Account>(this.URL_GET_ACCOUNT);
    }
    getPostById(id: number): Observable<Post>{
        return of(POST.find(post => post.id === id));
    }
    addPost(post: Post): void{
        let lastId: number = POST[POST.length - 1].id;
        post.id = ++lastId;
        POST.push(post);
    }
    updatePost(post: Post): void{
        const index = POST.findIndex(p => {
            return p.id === post.id;
        });
        POST.splice(index, 1, post);
    }
    deletePost(id: number): void{
        const index = POST.findIndex(p => {
            return p.id === id;
        });
        POST.splice(index, 1);
    }
}
