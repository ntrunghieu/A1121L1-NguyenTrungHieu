import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent implements OnInit {

  like = 0;
  dislike = 0;

  constructor() {
  }

  ngOnInit() {
  }

  likeThis() {
    this.like++;
  }
  dislikeThis(){
    this.dislike++;
  }

}
