// ignore_for_file: avoid_print, unused_local_variable

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

import '../../home/views/home_view.dart';

class LoginController extends GetxController {
  //TODO: Implement LoginController
  final emailController = TextEditingController();
  final passwordController = TextEditingController();

  final count = 0.obs;
  @override
  void onInit() {
    super.onInit();
  }

  @override
  void onReady() {
    super.onReady();
  }

  @override
  void onClose() {
    super.onClose();
  }

  var isLoading = false.obs;

  Future<void> loginUser(String email, String password) async {
    isLoading.value = true;

    const apiUrl =
        'https://5efd-1-54-251-49.ngrok-free.app/users';

    try {
      final response = await http.post(
        Uri.parse(apiUrl),
        body: {
          'email': email,
          'password': password,
        },
      );

      if (response.statusCode == 200) {
        Map<String, dynamic> data = json.decode(response.body);
        Get.offAll(() => HomeView());
      } else {
        print('Lỗi đăng nhập: ${response.statusCode}');
      }
    } catch (e) {
      print('Lỗi kết nối: $e');
    } finally {
      isLoading.value = false;
    }
  }
}
