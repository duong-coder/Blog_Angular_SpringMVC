import { Component, OnInit, OnChanges, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnChanges {
  @Input() heading: string;
  @Input() subHeading: string;
  @Input() dateCreate: Date;
  @Input() urlImage: string;
  @Input() flagHome: boolean;
  styleBinding: any = {'background-image': 'url(../../../assets/img/home-bg.jpg)'};
  constructor() {
   }

  ngOnInit(): void {
    
  }
  ngOnChanges(): void {
    this.initBackgroundImage();
  }
  initBackgroundImage(): void{
    if (this.urlImage){
      this.styleBinding = {'background-image': 'url(' + this.urlImage + ')'};
    }
  }
}
