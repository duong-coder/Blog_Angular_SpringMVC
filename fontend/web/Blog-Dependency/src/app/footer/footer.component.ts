import {Component, OnInit} from '@angular/core';
import {faGithub, faTwitter, faFacebook} from '@fortawesome/free-brands-svg-icons';
@Component({
    selector: 'app-footer',
    templateUrl: './footer.component.html',
    styleUrls: ['./footer.component.css', "../styles/style.component.css"]
})
export class FooterComponent implements OnInit{
    faGithub = faGithub;
    faTwitter = faTwitter;
    faFacebook = faFacebook;
    constructor(){

    }
    ngOnInit(){

    }
}