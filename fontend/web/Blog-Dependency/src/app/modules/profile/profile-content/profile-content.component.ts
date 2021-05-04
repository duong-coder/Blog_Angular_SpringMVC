import { Component, Input, OnInit } from '@angular/core';
import { faBullseye } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-profile-content',
  templateUrl: './profile-content.component.html',
  styleUrls: ['./profile-content.component.css']
})
export class ProfileContentComponent implements OnInit {
  @Input() hasIcon;
  @Input() icon;
  @Input() title;

  constructor() { }

  ngOnInit(): void {
  }

}
