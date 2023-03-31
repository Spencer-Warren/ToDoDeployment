import { Component } from '@angular/core';
import { Task } from '../classes/task';
import { Router } from '@angular/router';
import { RESTAPIService } from '../services/restapiservice.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent {
  tasks: Task[] = [];
  observableTasks: BehaviorSubject<Task[]> = new BehaviorSubject<Task[]>([]);

  constructor(private router: Router, private service: RESTAPIService) {
    this.getTasks();
  }

  get tasksList(): Observable<Task[]> {
    return this.observableTasks.asObservable();
  }

  getTasks() {
    this.service.getTasks().subscribe((data: any) => {
      this.tasks = data
      // put the tasks in the observable
      this.observableTasks.next(this.tasks);
    });
  }

  createTask() {
    this.router.navigate(['/tasks/create']);
  }

  editTask(taskId: number) {
    this.router.navigate(['/tasks/edit', taskId]);
  }

  deleteTask(taskId: number) {
    this.service.deleteTask(taskId).subscribe((data: any) => { this.getTasks() });
  }

  sort(col : string) {
    switch (col) {
      case 'date':
        this.tasks.sort((a, b) => { return a.dueDate.localeCompare(b.dueDate)});
        break;
      case 'title':
        this.tasks.sort((a, b) => { return a.title.localeCompare(b.title)});
        break;
      case 'status':
        this.tasks.sort((a, b) => { return a.status.localeCompare(b.status)});
        break;
      case 'description':
        this.tasks.sort((a, b) => { return a.description.localeCompare(b.description)});
        break;
    }
  }
}
