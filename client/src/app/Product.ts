import { Review } from "./Review"

export interface Product{
    productCode:string,
    reviews:Review[],
    productName:string,
    productBrand:string,
    price:Number,
    imgUrl:string
    productDesc:string,


    
} 