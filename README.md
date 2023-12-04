# lab01-week01
<h1>
  Bài 1:
</h1>
<p>
  Yêu cầu
Tạo một csdl có tên mydb với các bảng dữ liệu account (account_id, full_name, password, email, 
phone, status),  bảng  role  (role_id, role_name, description, status). Một account thuộc về  nhiều 
role, mỗi role có thể  có nhiều  account.    Trong đó status là trường để  chỉ  trạng thái mẫu tin (1-active, 0-deactive, -1-xóa)
(Tip:  tạo  1  bảng  thứ  ba  có  tên  grant_access  (account_id,  role_id,  is_grant,  note)  với  trường 
is_grant nhận giá trị 0-diasable, 1-enable.)
Một bảng có tên  log  để  ghi vết lần đăng nhập. Thông tin bao gồm: id  (auto-increment),  account 
đăng nhập, ngày giờ đăng nhập, ngày giờ đăng xuất, ghi chú.
Tạo một jakartaEE project có tên week01_lab_HotenSv_mssv (Có thể kết nối GitHub/GitLab để
push code). Thực hiện các công việc sau:
-  Tạo một servlet có tên  ControlServlet  (partern cùng tên). Servlet này nhận một tham số
(parameter)  có tên là  action. Tham số  này nhận các giá trị  chuỗi để  chỉ  các hành động 
tương ứng.
-  Kết nối với csdl, thực hiện các chức năng:
o  Thêm, cập nhật, xóa ở các bảng đã cho.
o  Đăng nhập
o  Hiển thị thông tin tài khoản (nếu đăng nhập thành công)
o  Hiển thị các quyền của một account.
o  Hiển thị các account của một role
o  Cấp quyền cho một account
o  Ghi log mỗi lần account đăng nhập, đăng xuất.
-  Một trang html hiển thị  cửa sổ  đăng nhập. Nếu đăng nhập  thành công và là quyền admin 
thì hiển thị trang dashboard cho phép quản lý các account khác (bao gồm các quyền thêm, 
xóa, sửa và cấp quyền). Còn không (không phải admin) thì hiển thị  thông tin của người 
đăng nhập cùng các quyền mà người đó có.
</p>

<h3>Sơ đồ quan hệ</h3>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/161b4731-058c-4914-93dc-3ec1a3cbe21c)


<h3>Đăng Nhập</h3>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/d848e6f2-ddb0-498f-8991-e30fa0beb0f0)

<h3>Quyền Manager</h3>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/5f53e865-88ae-41be-a203-437d4ee5a801)

<h4>Update</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/11efc8b2-9f1b-4136-b689-747e3de3e50c)

<h4>Create</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/4489a0de-e0c8-436d-887a-c767daedd21d)

<h4>Role Manager</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/4715f82e-7e08-490d-ae13-b5f476aa2e1c)

<h4>Create Role</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/1dde7fbc-16fd-48d4-9ff7-65190698c474)

<h4>Log Manager</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/3787447e-a155-47e2-8170-8e68ba2423b0)

<h3>Quyền staff</h3>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/5287db3b-100c-46a9-aaee-55c2a8f749ac)

<h4>Create account</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/74ff72d8-82aa-43d2-8a2a-5d5c2f84cc18)

<h4>Update account</h4>

![image](https://github.com/PhuongCuong/lab01-week01-www/assets/124875164/749398de-3a87-467a-8f62-f6d99f64feab)











