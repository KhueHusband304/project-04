
import { Link } from "react-router-dom";
import
{
    IconShoppingBagPlus
} from "@tabler/icons-react";

const Logo = () =>
{
    return (
        <div className="flex flex-row cursor-pointer flex-nowrap max-h-10 max-w-16">
            <div><IconShoppingBagPlus size={ 40 } /></div>
            <Link to="/" />
            <span className="text-2xl font-semibold text-orange-400">ShopMe</span>
        </div>
    );
};

export default Logo;