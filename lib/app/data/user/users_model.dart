class Users {
  String? id;
  String? name;
  String? fullname;
  String? email;
  String? password;
  String? phone;

  Users(
      {this.id,
      this.name,
      this.fullname,
      this.email,
      this.password,
      this.phone});

  Users.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    name = json['name'];
    fullname = json['fullname'];
    email = json['email'];
    password = json['password'];
    phone = json['phone'];
  }

  Map<String, dynamic> toJson() {
    final data = <String, dynamic>{};
    data['id'] = id;
    data['name'] = name;
    data['fullname'] = fullname;
    data['email'] = email;
    data['password'] = password;
    data['phone'] = phone;
    return data;
  }
}
