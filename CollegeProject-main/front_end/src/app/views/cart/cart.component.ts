import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cart } from 'src/app/models/Customer';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartList: Cart[] = []
  grandTotal: number = 0
  totalProduct: number = 0

  orderList : any = []

  constructor(private router: Router, private productService: ProductService, private tosterService : ToastrService)
  { }

  ngOnInit(): void {
    if (localStorage.getItem("cart") != null) {
      this.cartList = JSON.parse(localStorage.getItem("cart"))
      this.totalProduct = this.cartList.length
      this.cartList.forEach(cr => {
        this.grandTotal += cr.totalPrice
      })

      this.getCustomerOrder()

    }
  }

  navigateToProduct(id) {
    console.log("Event fired -> ", id)
    let url = "/productdesc/" + id
    this.router.navigateByUrl(url)
  }

  focusOutFunction(index, qty) {
    this.cartList[index].quantity = qty
    this.grandTotal -= Number(this.cartList[index].totalPrice)
    this.cartList[index].totalPrice = qty * Number(this.cartList[index].perPeice)
    this.grandTotal += this.cartList[index].totalPrice

  }

  removeCartItem(index) {
    console.log(this.cartList[index])
    this.cartList.splice(index, 1);
    console.log(this.cartList)
  }


  paymentStatus(status: boolean) {
    this.cartList = JSON.parse(localStorage.getItem("cart"))
    this.productService.placeOrder(this.cartList).subscribe(response => {
      console.log("Order Place status", response);
      this.cartList = []
      localStorage.removeItem("cart")
      this.tosterService.success("Order Placed")
      this.tosterService.success("Payment Completed")
    })
  }

  getCustomerOrder(){
    this.productService.getCustomerOrder().subscribe(response => {
      console.log("Customer Order -> ", response)
      this.orderList = response
    })
  }

}

@Override
public int compareTo(VariablePract o) {
  return this.id.compareTo(o.id);
}
	