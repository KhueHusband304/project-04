import Image from "next/image";
import Link from "next/link";
import React from "react";

const Logo = () =>
{
  return (
    <Link href="/">
      <a className="items-center justify-center flex-grow block w-full md:flex md:flex-grow-0">
        <Image
          src="/images/techvib.png"
          alt="zishop-logo"
          width={ 150 }
          height={ 100 }
          objectFit="fill"
          className="cursor-pointer md:ltr:-mr-3"
        />
      </a>
    </Link>
  );
};

export default Logo;
