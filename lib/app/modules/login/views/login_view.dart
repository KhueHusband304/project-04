import 'package:flutter/material.dart';

import 'package:get/get.dart';
import 'package:project/widgets/custom_elevated_button.dart';
import 'package:project/widgets/custom_text_form_field.dart';

import '../../../../core/app_export.dart';
import '../../../../core/utils/validation_functions.dart';
import '../controllers/login_controller.dart';

class LoginView extends GetView<LoginController> {
  LoginView({Key? key}) : super(key: key);

  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBody: true,
      extendBodyBehindAppBar: true,
      resizeToAvoidBottomInset: false,
      body: SafeArea(
        child: Container(
          width: SizeUtils.width,
          height: SizeUtils.height,
          decoration: BoxDecoration(
            color: theme.colorScheme.onErrorContainer.withOpacity(1),
            image: DecorationImage(
              image: AssetImage(
                ImageConstant.img03Login,
              ),
              fit: BoxFit.cover,
            ),
          ),
          child: Center(
            child: SingleChildScrollView(
              padding: EdgeInsets.only(
                bottom: MediaQuery.of(context).viewInsets.bottom,
              ),
              child: Form(
                key: _formKey,
                child: Container(
                  width: double.maxFinite,
                  padding: EdgeInsets.symmetric(
                    horizontal: 20.h,
                    vertical: 69.v,
                  ),
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Flexible(
                          flex: 1,
                          child: Container()), // Use Flexible instead of Spacer
                      Align(
                        alignment: Alignment.centerLeft,
                        child: Text(
                          "Login",
                          style: theme.textTheme.displayLarge,
                        ),
                      ),
                      SizedBox(height: 4.v),
                      Align(
                        alignment: Alignment.centerLeft,
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              "Good to see you back!",
                              style: CustomTextStyles.bodyLargeGray90001,
                            ),
                            CustomImageView(
                              imagePath: ImageConstant.imgHeart,
                              height: 15.adaptSize,
                              width: 15.adaptSize,
                              margin: EdgeInsets.only(
                                left: 10.h,
                                top: 3.v,
                                bottom: 7.v,
                              ),
                            ),
                          ],
                        ),
                      ),
                      SizedBox(height: 20.v),
                      //custometextformfield email
                      CustomTextFormField(
                        controller: emailController,
                        hintText: "lbl_email".tr,
                        hintStyle:
                            CustomTextStyles.titleSmallPoppinsBluegray100,
                        textInputAction: TextInputAction.done,
                        textInputType: TextInputType.emailAddress,
                        validator: (value) {
                          if (value == null ||
                              (!isValidEmail(value, isRequired: true))) {
                            return "err_msg_please_enter_valid_email".tr;
                          }
                          return null;
                        },
                        contentPadding: EdgeInsets.symmetric(
                          horizontal: 19.h,
                          vertical: 15.v,
                        ),
                        borderDecoration: TextFormFieldStyleHelper.fillGray,
                        fillColor: appTheme.gray5001,
                      ),
                      //custometextformfield password
                      SizedBox(height: 20.v),
                      CustomTextFormField(
                        controller: passwordController,
                        hintText: "lbl_password".tr,
                        hintStyle:
                            CustomTextStyles.titleSmallPoppinsBluegray100,
                        textInputAction: TextInputAction.done,
                        textInputType: TextInputType.visiblePassword,
                        validator: (value) {
                          if (value == null ||
                              (!isValidPassword(value, isRequired: true))) {
                            return "err_msg_please_enter_valid_password".tr;
                          }
                          return null;
                        },
                        contentPadding: EdgeInsets.symmetric(
                          horizontal: 19.h,
                          vertical: 15.v,
                        ),
                        borderDecoration: TextFormFieldStyleHelper.fillGray,
                        fillColor: appTheme.gray5001,
                      ),
                      SizedBox(height: 36.v),
                      CustomElevatedButton(
                        height: 61.v,
                        width: double.infinity,
                        text: "Login",
                        buttonStyle: CustomButtonStyles.fillPrimary,
                        buttonTextStyle:
                            CustomTextStyles.titleLargeNunitoSansGray10001,
                        onTap: () async {
                          await Get.toNamed(Routes.HOME);
                        },
                      ),

                      SizedBox(height: 16.v),
                      CustomElevatedButton(
                        text: 'Register',
                        onPressed: () {
                           Get.toNamed(Routes.REGISTER);
                        },
                      ),
                      Flexible(
                          flex: 1,
                          child: Container()), // Use Flexible instead of Spacer
                    ],
                  ),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
