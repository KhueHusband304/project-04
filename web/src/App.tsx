

import { MantineProvider } from "@mantine/core";
import { RouterProvider } from "react-router-dom";
import { routes } from './routes';


function App ()
{
  return <div className='flex p-5 bg-white flex-nowrap'>
    <MantineProvider>
      <RouterProvider router={ routes } />
    </MantineProvider>
  </div>;
}

export default App;
