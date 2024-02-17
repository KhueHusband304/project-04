import 'package:flutter/material.dart';
import 'package:project/core/app_export.dart';
import 'package:project/theme/custom_text_style.dart';
import 'package:project/theme/theme_helper.dart';
// ignore: must_be_immutable
class AppbarSubtitleOne extends StatelessWidget {
  AppbarSubtitleOne({
    Key? key,
    required this.text,
    this.margin,
    this.onTap,
  }) : super(
          key: key,
        );

  String text;

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
        child: Text(
          text,
          style: CustomTextStyles.titleLargeBlueA700.copyWith(
            color: appTheme.blueA700,
          ),
        ),
      ),
    );
  }
}
