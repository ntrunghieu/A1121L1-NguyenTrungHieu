import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  constructor() { }
  private _dictionary: Dictionary[] = [
    {word: 'Book', mean: 'Sách'},
    {word: 'Student', mean: 'Học sinh'},
    {word: 'Teacher', mean: 'Giáo viên'},
    {word: 'Man', mean: 'Đàn ông'},
    {word: 'Computer', mean: 'Máy tính'},
    {word: 'Dog', mean: 'Con chó'},
    {word: 'Cat', mean: 'Con mèo'},
  ];

  get dictionary(): Dictionary[] {
    return this._dictionary;
  }

  set dictionary(value: Dictionary[]) {
    this._dictionary = value;
  }

  findByEng(word: string) {
    for (let i = 0; i < this.dictionary.length; i++) {
      if (this.dictionary[i].word === word) {
        return this.dictionary[i];
      }
    }
    return undefined;
  }
}
