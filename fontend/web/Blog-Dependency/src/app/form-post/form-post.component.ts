import { Component, OnInit } from '@angular/core';
import {faMarkdown} from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-form-post',
  templateUrl: './form-post.component.html',
  styleUrls: ['./form-post.component.css', '../navbar/navbar.component.css']
})
export class FormPostComponent implements OnInit {
  faMarkdown = faMarkdown;
  constructor() { }

  ngOnInit(): void {
  }

}
