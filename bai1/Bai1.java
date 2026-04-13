package com.book.session7.bai1;

//Phần 1
//-Tên cửa hàng lại bị null vì Trong Model cod private String name; Nhưng trong HTML thì lại là
//<input type="text" name="restaurantName" />
//-Ô checkbox trạng thái active kiểu boolean lại không thể hoạt động đúng với thẻ HTML hiện tại vì value
//không phù hợp kiểu boolean,

//Phần 2
//<form action="/merchant/update-profile" method="POST">
//    <label>Tên cửa hàng:</label>
//    <input type="text" name="name" />
//
//    <br/>
//
//    <label>Số điện thoại:</label>
//    <input type="text" name="phone" />
//
//    <br/>
//
//    <label>Đang mở cửa:</label>
//
//    <input type="hidden" name="active" value="false" />
//
//    <input type="checkbox" name="active" value="true" />
//
//    <br/>
//
//    <button type="submit">Lưu thông tin</button>
//</form>