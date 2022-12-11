# QuanLyKhuyenMai_VoDuyKhoi
 
----QUẢN LÝ KHUYẾN MÃI----
Một cửa hàng cần quản lý khuyến mãi của các sản phẩm đang bán, một khuyến mãi có thể
áp dụng cho một số sản phẩm, mỗi sản phẩm gồm thông tin mã sản phẩm (số nguyên tăng 
dần), tên sản phẩm, giá bán, danh mục sản phẩm và danh sách các khuyến mãi của sản 
phẩm. Mỗi khuyến mãi gồm mã khuyến mãi (tự động sinh ra theo các quy tắc phụ thuộc 
từng loại khuyến mãi), ngày tạo và ngày hết hiệu lực. Khuyến mã được chia thành các loại:
- Khuyến mãi loại A: giảm trực tiếp trên giá sản phẩm. Mã này dài 3 ký tự, bắt đầu bằng 
A và hai ký tự sau là số tăng dần, chẳng hạn A01, A02. Loại khuyến mãi này có thêm 
thông tin tỷ lệ phần trăm giảm giá trên sản phẩm. 
- Khuyến mãi loại B: tặng kèm dịch vụ như vé xem phim, vé xem hài lịch. Mã này dài 
5 ký tự, bắt đầu bằng B và 4 ký tự số sinh ngẫu nhiên từ 1000 đến 9999, chẳng hạn 
B1234, B1456. Loại khuyến mãi này có thêm danh sách các dịch vụ tặng kèm. 
- Khuyễn mãi loại C: giảm giá trên một sản phẩm mua kèm thuộc danh mục chỉ định. 
Mã này dài 5 ký tự, bắt đầu bằng C và 4 ký tự sau là số nguyên tăng dần, chẳng hạn 
C0001, C0002. Loại khuyến mãi có thêm thông tin loại sản phẩm được giảm khi mua 
kèm và tỷ lệ phần trăm giảm.
Viết chương trình cho phép quản lý sản phẩm và khuyến mãi.
- Thêm sản phẩm vào danh sách.
- Tìm kiếm sản phẩm theo têm, theo khoảng giá chỉ định và theo từng loại khuyến mãi.
- Thêm khuyến mãi vào một sản phẩm.
- Xoá các khuyến mãi hết hiệu lực khỏi các sản phẩm.
- Cho phép người dùng nhập số ngày x, xác định tất cả các khuyến mãi còn x ngày hết 
hiệu lực.
- Hiển thị thông tin khuyến mãi của sản phẩm chỉ định theo mã sản phẩm hoặc tên sản 
phẩm.
- Xem danh sách sản phẩm có chứa khuyến mãi theo từng loại khuyến mãi chỉ định. 
- Sắp xếp danh sách sản phẩm giảm dần theo số lượng khuyến mãi còn hiệu lực
