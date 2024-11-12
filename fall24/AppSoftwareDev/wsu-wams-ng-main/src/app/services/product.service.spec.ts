import { TestBed } from '@angular/core/testing';
import { ProductService } from './product.service';
import { Product } from '../models/product.model';
import {HttpClient, HttpClientModule, HttpHandler} from "@angular/common/http";

describe('ProductService', () => {
  let service: ProductService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [HttpClient, HttpHandler],
    }).compileComponents();
    service = TestBed.inject(ProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all products', () => {
    const products = service.getProducts();
    expect(products.length).toBe(3);
  });

  it('should find a product by SKU code', () => {
    const SKUCode = '123456789012';
    const product = service.getProductBySKUCode(SKUCode);
    expect(product).toBeTruthy();
    expect(product?.universalProductCode).toBe(SKUCode);
  });

  it('should add a new product', () => {
    const newProduct: Product = {
      skuCode: '12345',
      skuDescription: 'Widget B',
      unitCost: 15.0,
      productTypeCode: 'WIDGET',
      universalProductCode: '987654321098',
      active: true,
    };
    service.addProduct(newProduct);
    const products = service.getProducts();
    expect(products.length).toBe(4);
    expect(products).toContain(newProduct);
  });

  it('should update an existing product', () => {
    const updatedProduct: Product = {
      skuCode: '12345',
      skuDescription: 'Widget A Updated',
      unitCost: 12.0,
      productTypeCode: 'WIDGET',
      universalProductCode: '123456789012',
      active: true,
    };
    service.updateProduct('123456789012', updatedProduct);
    const product = service.getProductBySKUCode('123456789012');
    expect(product).toBeTruthy();
    expect(product?.skuDescription).toBe('Widget A Updated');
  });
});
