import {Component, Input, OnInit} from '@angular/core';
import {faGithub, faTwitter, faFacebook} from '@fortawesome/free-brands-svg-icons';
@Component({
    selector: 'app-footer',
    templateUrl: './footer.component.html',
    styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit{
    @Input() urlTwitter;
    @Input() urlFacebook;
    @Input() urlGithub;
    
    faGithub = faGithub;
    faTwitter = faTwitter;
    faFacebook = faFacebook;
    constructor(){

    }
    ngOnInit(){

    }
}