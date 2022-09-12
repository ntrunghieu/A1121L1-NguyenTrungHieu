import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {FormControl, FormGroup} from '@angular/forms';
import {Todo} from '../todo';
import {Router} from '@angular/router';
import {TodoServiceService} from '../todo-service.service';

class ServiceTodoService {
}

@Component({
  selector: 'app-todo-app',
  templateUrl: './todo-app.component.html',
  styleUrls: ['./todo-app.component.css']
})
export class TodoAppComponent implements OnInit {

  todos: Todo[] = [];
  contentInput: FormGroup;
  todo: Todo = {};
  constructor(
    private _service: TodoServiceService,
    private _router: Router
  ) {
  }

  ngOnInit(): void {
    this._service.getAll().subscribe(data => {
        this.todos = data;
      }, error => {
        console.log("errors");
      }
    );
    this.contentInput = new FormGroup(
      {
        id: new FormControl(''),
        content: new FormControl(''),
        complete: new FormControl(false)
      }
    );
  }

  toggleTodo(id: number) {
   this._service.getById(id).subscribe(data => {
      this.todo = data;
      this.todo.complete = !this.todo.complete;
      this._service.update(id, this.todo).subscribe(() => {
        console.log("success");
        location.reload();
      }, error => {
        console.log("error");
      });
    }, error => {
      console.log("errors");
    });
  }

  change() {
    this._service.save(this.contentInput.value).subscribe(()=>{
      console.log("success");
      alert("Ban da tao thanh cong " +this.contentInput.value.content);
      location.reload();
    }, error => {
      console.log("errors");
    });
  }

  delete(id: number) {
    this._service.delete(id).subscribe(() => {
      console.log("success");
      location.reload();
    }, error => {
      console.log("error");
    });
  }
}
