import 'package:flutter/material.dart';
import 'package:project/core/app_export.dart';

import '../theme/theme_helper.dart';

class CustomIconButton extends StatelessWidget {
  CustomIconButton({
    Key? key,
    this.alignment,
    this.height,
    this.width,
    this.padding,
    this.decoration,
    this.child,
    this.onTap,
  }) : super(
          key: key,
        );

  final Alignment? alignment;

  final double? height;

  final double? width;

  final EdgeInsetsGeometry? padding;

  final BoxDecoration? decoration;

  final Widget? child;

  final VoidCallback? onTap;

  @override
  Widget build(BuildContext context) {
    return alignment != null
        ? Align(
            alignment: alignment ?? Alignment.center,
            child: iconButtonWidget,
          )
        : iconButtonWidget;
  }

  Widget get iconButtonWidget => SizedBox(
        height: height ?? 0,
        width: width ?? 0,
        child: IconButton(
          padding: EdgeInsets.zero,
          icon: Container(
            height: height ?? 0,
            width: width ?? 0,
            padding: padding ?? EdgeInsets.zero,
            decoration: decoration ??
                BoxDecoration(
                  color: appTheme.blueGray10001,
                  borderRadius: BorderRadius.circular(14.h),
                ),
            child: child,
          ),
          onPressed: onTap,
        ),
      );
}

/// Extension on [CustomIconButton] to facilitate inclusion of all types of border style etc
extension IconButtonStyleHelper on CustomIconButton {
  static BoxDecoration get fillPrimary => BoxDecoration(
        color: theme.colorScheme.primary,
        borderRadius: BorderRadius.circular(15.h),
      );
  static BoxDecoration get fillGray => BoxDecoration(
        color: appTheme.gray5001,
        borderRadius: BorderRadius.circular(17.h),
      );
  static BoxDecoration get fillOnError => BoxDecoration(
        color: theme.colorScheme.onError,
        borderRadius: BorderRadius.circular(15.h),
      );
  static BoxDecoration get fillOnErrorContainer => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(25.h),
      );
  static BoxDecoration get outlineOnErrorContainer => BoxDecoration(
        color: theme.colorScheme.primary,
        borderRadius: BorderRadius.circular(11.h),
        border: Border.all(
          color: theme.colorScheme.onErrorContainer.withOpacity(1),
          width: 2.h,
        ),
      );
  static BoxDecoration get fillRed => BoxDecoration(
        color: appTheme.red50,
        borderRadius: BorderRadius.circular(15.h),
      );
  static BoxDecoration get fillGrayTL11 => BoxDecoration(
        color: appTheme.gray5001,
        borderRadius: BorderRadius.circular(11.h),
      );
  static BoxDecoration get outlineBlueA => BoxDecoration(
        borderRadius: BorderRadius.circular(25.h),
        border: Border.all(
          color: appTheme.blueA700,
          width: 2.h,
        ),
      );
  static BoxDecoration get fillOnErrorContainerTL17 => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(17.h),
      );
  static BoxDecoration get fillOnErrorContainerTL8 => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(8.h),
      );
  static BoxDecoration get outlineBlueATL15 => BoxDecoration(
        color: appTheme.blueA700,
        borderRadius: BorderRadius.circular(15.h),
        border: Border.all(
          color: appTheme.blueA700,
          width: 1.h,
        ),
      );
  static BoxDecoration get outlineBlack => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(15.h),
        boxShadow: [
          BoxShadow(
            color: appTheme.black90002.withOpacity(0.16),
            spreadRadius: 2.h,
            blurRadius: 2.h,
            offset: Offset(
              0,
              3,
            ),
          ),
        ],
      );
  static BoxDecoration get fillBlueA => BoxDecoration(
        color: appTheme.blueA700,
        borderRadius: BorderRadius.circular(15.h),
      );
  static BoxDecoration get outlineBlueATL151 => BoxDecoration(
        borderRadius: BorderRadius.circular(15.h),
        border: Border.all(
          color: appTheme.blueA700,
          width: 2.h,
        ),
      );
  static BoxDecoration get fillRedTL8 => BoxDecoration(
        color: appTheme.red50,
        borderRadius: BorderRadius.circular(8.h),
      );
  static BoxDecoration get fillGrayTL15 => BoxDecoration(
        color: appTheme.gray20002,
        borderRadius: BorderRadius.circular(15.h),
      );
  static BoxDecoration get fillIndigo => BoxDecoration(
        color: appTheme.indigo50,
        borderRadius: BorderRadius.circular(17.h),
      );
  static BoxDecoration get fillIndigoTL20 => BoxDecoration(
        color: appTheme.indigo50,
        borderRadius: BorderRadius.circular(20.h),
      );
  static BoxDecoration get outlineBlackTL20 => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(20.h),
        boxShadow: [
          BoxShadow(
            color: appTheme.black90002.withOpacity(0.16),
            spreadRadius: 2.h,
            blurRadius: 2.h,
            offset: Offset(
              0,
              3,
            ),
          ),
        ],
      );
  static BoxDecoration get outlinePrimary => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(30.h),
        border: Border.all(
          color: theme.colorScheme.primary,
          width: 1.h,
        ),
        boxShadow: [
          BoxShadow(
            color: appTheme.black90002.withOpacity(0.16),
            spreadRadius: 2.h,
            blurRadius: 2.h,
            offset: Offset(
              0,
              5,
            ),
          ),
        ],
      );
  static BoxDecoration get outlineRed => BoxDecoration(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        borderRadius: BorderRadius.circular(30.h),
        border: Border.all(
          color: appTheme.red300,
          width: 1.h,
        ),
        boxShadow: [
          BoxShadow(
            color: appTheme.black90002.withOpacity(0.16),
            spreadRadius: 2.h,
            blurRadius: 2.h,
            offset: Offset(
              0,
              5,
            ),
          ),
        ],
      );
}
