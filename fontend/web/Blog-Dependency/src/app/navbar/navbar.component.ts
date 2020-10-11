import { Component, OnInit } from '@angular/core';
import {faGithub} from '@fortawesome/free-brands-svg-icons';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css', "../styles/style.component.css"]
})
export class NavbarComponent implements OnInit {
  faGithub = faGithub;
  constructor() { }

  ngOnInit(): void {
  }

}
