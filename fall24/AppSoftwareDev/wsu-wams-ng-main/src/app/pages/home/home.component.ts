import { Component } from '@angular/core';
import { OptionsDropdownComponent } from '../../shared/options-dropdown/options-dropdown.component';
import { OptionPair } from '../../shared/shared.model';
import { CustomTableComponent } from '../../shared/custom-table/custom-table.component';
import {DialogModule} from "primeng/dialog";
import {TechnicianFormComponent} from "../technicians/technician-form/technician-form.component";
import {NgIf} from "@angular/common";
import {CustomerService} from "../../services/customer.service";
import {CustomerFormComponent} from "../customers/customer-form/customer-form.component";
import {Customer} from "../../models/customer.model";
import {Technician} from "../../models/technician.model";
import {TechnicianService} from "../../services/technician.service";
import {WorkOrderDetail} from "../../models/work-order-detail.model";
import {WorkOrderDetailService} from "../../services/work-order-detail.service";
import {OrderFormComponent} from "../orders/order-form/order-form.component";
import {CarouselModule} from "primeng/carousel";
import {CarouselData} from "../../models/carousel-data.model";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    OptionsDropdownComponent,
    CustomTableComponent,
    DialogModule,
    TechnicianFormComponent,
    NgIf,
    CustomerFormComponent,
    OrderFormComponent,
    CarouselModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})

export class HomeComponent {

  viewOptions: OptionPair[] = [{displayLabel: 'Customers', option:'view'}, {displayLabel: 'Technicians', option:'view'}, {displayLabel: 'Orders', option:'view'}]; // array to hold string-link object pairs for clicking to route to view components
  createOptions: OptionPair[] = [{displayLabel: 'Customers', option:'create'}, {displayLabel: 'Technicians', option:'create'}, {displayLabel: 'Orders', option:'create'}]; // array to hold string-link object pairs for clicking to route to creation components

  headerColumns: any[] = []; // freeform array to hold different header values for ptable as we change views
  viewData: any[] = []; // freeform array to hold different objects to populate ptable with
  display: string = ''; // decide which screen (create or view) to display
  actionDataType = ''; // decide which data objects we are creating and viewing
  showModal = false;
  carouselDisplays: CarouselData[] = [];

  constructor(private customerService: CustomerService, private technicianService: TechnicianService, private orderService: WorkOrderDetailService) {
    // initialize carousel content once when this component is instantiated
    this.carouselDisplays.push({ // push powerful tools panel
      displayText: 'Powerful Tools for a Modern Business',
      image: 'assets/img/clipboard-workers.png'
    });
    this.carouselDisplays.push({ // push easy management panel
      displayText: 'Easy Management Day or Night',
      image: 'assets/img/night-stock-img.jpg'
    });
    this.carouselDisplays.push({ // push customer support panel
      displayText: 'Friendly Fast Customer Service 24/7',
      image: 'assets/img/customer-support-stock.jpg'
    });
  }

  private defineColumns(type: string) { // defines header data based on options selected
    if (type == 'Customers') { // HEADERS FOR CUSTOMERS
      this.headerColumns = [
        { field: 'lastName', header: 'Customer' },
        { field: 'email', header: 'Email'},
        { field: 'address', header: 'Address' }
      ];
    } else if (type == 'Technicians') { // HEADERS FOR TECHNICIANS
      this.headerColumns = [
        { field: 'lastName', header: 'Technician', sortable: true },
        { field: 'type', header: 'Permit Type', sortable: true },
        { field: 'workPermits', header: 'Permit State', sortable: false }
      ];
    } else if (type == 'Orders') { // HEADERS FOR ORDERS
      this.headerColumns = [
        { field: 'lastName', header: 'Customer', sortable: false },
        { field: 'email', header: 'Email', sortable: true },
        { field: 'address', header: 'Address', sortable: false }
      ];
    }
  }

  submitCustomer(newCustomer: Customer) { // submit new Customer data
    this.customerService.addCustomer(newCustomer);
    this.showModal = false;
  }

  submitTechnician(newTechnician: Technician) { // submit new Technician data
    this.technicianService.addTechnician(newTechnician);
    this.showModal = false;
  }

  submitOrder(newOrder: WorkOrderDetail) { // submit new Order data
    this.orderService.updateWorkOrderDetail(newOrder.WorkOrderNumber, newOrder);
    this.showModal = true;
  }

  switchView(viewOption:OptionPair) { // switch the homepage's view based on selected options
    this.display = viewOption.option;
    this.actionDataType = viewOption.displayLabel;
    if (viewOption.option === 'view') {
      this.showModal = false;
      this.defineColumns(viewOption.displayLabel);
      if (viewOption.displayLabel === 'Customers') { // HANDLE GETTING CUSTOMER DATA
        this.customerService.getCustomers().subscribe({
          next:(res) => {
            this.viewData = res;
          }, error:(err) => {
            console.error('An error occurred: ' + err);
          }, complete:()=>{}
        });
      } else if (viewOption.displayLabel === 'Technicians') { // HANDLE GETTING TECH DATA
        this.technicianService.getTechnicians().subscribe((res) => {
          this.viewData = res;
        });
      }
    } else if (viewOption.option === 'create') {
      this.showModal = true;
    }
  }

}
