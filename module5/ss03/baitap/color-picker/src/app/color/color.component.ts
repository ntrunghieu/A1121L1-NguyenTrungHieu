import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {

  color = ``;
  constructor() { }

  ngOnInit(): void {
  }

  red() {
    this.color = 'red';
  }

  yellow() {
    this.color = 'yellow';
  }

  blue() {
    this.color = 'blue';
  }

}
