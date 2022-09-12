import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../../service/dictionary.service';
import {Dictionary} from '../../model/dictionary';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {
  dictionary: Dictionary[] = this._dictionary.dictionary;
  dic: Dictionary[] = [];
  constructor(private _dictionary: DictionaryService) { }

  ngOnInit(): void {
    // this.getAll();
  }
  submit() {

  }

  search(value: string) {

  }
  getAll() {
    // return this.dictionary.getAll();
  }
}
