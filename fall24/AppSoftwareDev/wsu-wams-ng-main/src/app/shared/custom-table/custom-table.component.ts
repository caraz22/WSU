import {
  Component,
  Input,
  Output,
  EventEmitter,
  TemplateRef,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import {NgClass, NgForOf, NgIf, NgTemplateOutlet} from "@angular/common";

interface TableColumn {
  field: string;
  header: string;
  template?: TemplateRef<any> | null;
  sortable?: boolean;
}

@Component({
  selector: 'app-custom-table',
  templateUrl: './custom-table.component.html',
  styleUrls: ['./custom-table.component.scss'],
  imports: [
    NgClass,
    NgForOf,
    NgIf,
    NgTemplateOutlet
  ],
  standalone: true
})
export class CustomTableComponent implements OnChanges {
  @Input() data: any[] = [];
  @Input() columns: TableColumn[] = [];
  @Output() sort = new EventEmitter<string>();

  sortedData: any[] = [];

  ngOnChanges(changes: SimpleChanges) {
    if (changes['data']) {
      this.sortedData = [...this.data];
    }
  }

  onSort(event: any) {
    this.sort.emit(event);
  }
}
