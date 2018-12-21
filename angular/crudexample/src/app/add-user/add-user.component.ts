import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators ,FormsModule,NgForm } from '@angular/forms';
import {first} from "rxjs/operators";
import {UserService} from "../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  addForm: FormGroup;
  firstname:string='';
  lastname:string='';
  email:string='';

  constructor(private formbuilder: FormBuilder, private router: Router, private userService: UserService) {
    this.addForm = formbuilder.group({
          'firstname' : [null, Validators.required],
          'lastname' : [null, Validators.required],
          'email':[null, Validators.compose([Validators.required,Validators.email])]
        });
  }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.createUser(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-user']);
      });
  }

}
