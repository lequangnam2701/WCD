import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  searchText = '';

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAll().subscribe(data => this.employees = data);
  }

  search(): void {
    if (this.searchText.trim()) {
      this.employeeService.search(this.searchText).subscribe(data => this.employees = data);
    } else {
      this.loadEmployees();
    }
  }

  deleteEmployee(id: string): void {
    if (confirm('Bạn có chắc chắn muốn xóa?')) {
      this.employeeService.delete(id).subscribe(() => this.loadEmployees());
    }
  }
}


