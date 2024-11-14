import { Component } from '@angular/core';

interface ContactFormModel {
  name: string;
  email: string;
}

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export class ContactFormComponent {

  model: ContactFormModel = {
    name:'',
    email:''
  };

  onSubmit(form: ContactFormModel) {
    // if (form.valid) {
    //   console.log('Form submitted');
    // } else {
    //   console.log('Form invalid');
    // }
  }
}
