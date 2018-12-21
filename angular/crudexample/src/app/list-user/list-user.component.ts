import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../service/user.service";
import {User} from "../model/user.model";


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

   displayedColumns: string[] = ['id', 'firstname', 'lastname', 'email', 'actions'];

   users: User[];

   constructor(private router: Router, private userService: UserService) { }

   ngOnInit() {
     this.userService.getUsers()
       .subscribe( data => {
         this.users = data;
       });
   }

   deleteUser(user: User): void {
     this.userService.deleteUser(user.id)
       .subscribe( data => {
         this.users = this.users.filter(u => u !== user);
       })
   };

   updateUser(user: User): void {
     localStorage.removeItem("updateUserId");
     localStorage.setItem("updateUserId", user.id.toString());
     this.router.navigate(['update-user']);
   };

   addUser(): void {
     this.router.navigate(['add-user']);
   };
}
