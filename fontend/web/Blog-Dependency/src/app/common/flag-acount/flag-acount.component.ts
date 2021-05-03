import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-flag-acount',
  templateUrl: './flag-acount.component.html',
  styleUrls: ['./flag-acount.component.css']
})
export class FlagAcountComponent implements OnInit{
  flagIsLoginPage = false;
  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.url.subscribe((urlSegment) => {
      const urlSegmentExist = urlSegment.find((url) => {
        return url.path.includes('login') ? url : null;
      });
      if (urlSegmentExist != null) {
        this.flagIsLoginPage = true;
      } else {
        this.flagIsLoginPage = false;
      }
    });
  }

  redirecPageLogin(): void {
    // this.flagIsLoginPage = !this.flagIsLoginPage;
    if (this.flagIsLoginPage) {
      this.goBack();
    }else{
      this.goLoginPage();
    }
  }
  goBack(): void {
    this.router.navigateByUrl('/home');
  }

  goLoginPage(): void{
    this.router.navigateByUrl('/login');
  }
}
