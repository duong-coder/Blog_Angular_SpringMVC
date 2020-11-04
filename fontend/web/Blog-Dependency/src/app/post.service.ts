import { Injectable, INJECTOR } from '@angular/core';
import { Observable, of } from 'rxjs';
import {POST} from './data-post';
import { DateService } from './date.service';
import { Post } from './post';

@Injectable()
export class PostService{
    constructor(
        private dateService: DateService
    ){}
    getAllPost(): Observable<Post[]>{
        return of(POST);
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
}
