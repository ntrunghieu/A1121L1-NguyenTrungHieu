import { Component, OnInit } from '@angular/core';
import {Dictionary} from '../../model/dictionary';
import {ActivatedRoute, Router} from '@angular/router';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: string;
  dictionary: Dictionary | undefined;
  constructor(
    private _router: Router,
    private _activatedRouter: ActivatedRoute,
    private _dictionary: DictionaryService
  ) { }

  ngOnInit(): void {
    this.word = this._activatedRouter.snapshot.params.word;
    this.dictionary = this._dictionary.findByEng(this.word);
  }

  return() {
    this._router.navigateByUrl('/');
  }
}
