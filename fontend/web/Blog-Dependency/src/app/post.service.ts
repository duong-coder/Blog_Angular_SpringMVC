import { Injectable, INJECTOR } from '@angular/core';
import { Observable, of } from 'rxjs';
import {POST} from './data-post';
import { Post } from './post';

@Injectable()
export class PostService{
    constructor(){}
    getAllPost(): Observable<Post[]>{
        return of(POST);
    }
    getPostById(id: number): Observable<Post>{
        return of(POST.find(post => post.id === id));
    }
}
