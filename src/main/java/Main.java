import model.Sucursal;
import service.IDAOSucursal;
import service.ImplDAOSucursal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IDAOSucursal dao = new ImplDAOSucursal();
        Sucursal entity = new Sucursal();
        entity.setNombre("Jinotega");
        entity.setDescripcion("Sucursal de Jinotega");
        entity.setId(4);
        dao.insert(entity);
        List<Sucursal> lista = dao.getAll("Sucursal.All");
        lista.forEach(System.out::println);
    }
}
