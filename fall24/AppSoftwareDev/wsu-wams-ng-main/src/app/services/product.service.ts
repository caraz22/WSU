import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import {Observable} from "rxjs";
import {HttpWrapperService} from "../shared/http-wrapper.service";

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private products: Product[] = [
    // Sample data
    {
      skuCode: '123456',
      skuDescription: 'Widget A',
      unitCost: 10.00,
      productTypeCode: 'P',
      universalProductCode: '123456789012',
      active: true,
    },
    {
      skuCode: '348951',
      skuDescription: 'Dishwasher Installation',
      unitCost: 150.00,
      productTypeCode: 'S',
      universalProductCode: '',
      active: true,
    },
    {
      skuCode: '348956',
      skuDescription: 'Dishwasher Removal',
      unitCost: 50.00,
      productTypeCode: 'U',
      universalProductCode: '',
      active: true,
    },
  ];

  private readonly baseUrl = 'https://your-base-url-here.com'

  constructor(private readonly http: HttpWrapperService) {}

  getProductsViaHttp(): Observable<Product[]> {
    return this.http.doGet(`${this.baseUrl}/products`, {});
  }

  getProducts(): Product[] {
    return this.products;
  }

  getProductBySKUCode(skuCode: string): Product | undefined {
    return this.products.find((product) => product.universalProductCode === skuCode);
  }

  addProduct(product: Product): void {
    this.products.push(product);
  }

  updateProduct(skuCode: string, updatedProduct: Product): void {
    const index = this.products.findIndex((p) => p.universalProductCode === skuCode);
    if (index !== -1) {
      this.products[index] = updatedProduct;
    }
  }
}
