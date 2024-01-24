import 'package:flutter/material.dart';
import 'package:project/core/app_export.dart';
import 'package:project/theme/custom_text_style.dart';
import 'package:project/widgets/custom_elevated_button.dart';
import 'package:project/theme/theme_helper.dart';
// ignore: must_be_immutable
class AppbarTitleButton extends StatelessWidget {
  AppbarTitleButton({
    Key? key,
    this.margin,
    this.onTap,
  }) : super(
          key: key,
        );

  EdgeInsetsGeometry? margin;

  Function? onTap;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        onTap!.call();
      },
      child: Padding(
        padding: margin ?? EdgeInsets.zero,
        child: CustomElevatedButton(
          height: 35.v,
          width: 115.h,
          text: "lbl_my_activity".tr,
          buttonStyle: CustomButtonStyles.fillPrimary,
          buttonTextStyle: CustomTextStyles.titleMediumOnErrorContainerMedium,
        ),
      ),
    );
  }
}
