package proyectoOptativa.tiendaCafe.service;

import proyectoOptativa.tiendaCafe.dto.CategoriaDTO;
import proyectoOptativa.tiendaCafe.model.Categoria;
import proyectoOptativa.tiendaCafe.model.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    // creamos la lista de las categorias
    private final List<Categoria> categorias = new ArrayList<>();
    private int siguienteId = 1; // para que se pueda incrementar
    public CategoriaService() {
        anadirEjemplo("Café molido", "Café molido listo para preparar", TipoProducto.CAFE);
        anadirEjemplo("Café en grano", "Café en grano",  TipoProducto.CAFE);
        anadirEjemplo("Cápsulas", "Cápsulas de café", TipoProducto.CAFE);
        anadirEjemplo("Accesorios", "Cafeteras", TipoProducto.ACCESORIOS);
    }

    private void anadirEjemplo(String nombre, String descripcion, TipoProducto tipoProducto) {
        Categoria categoria = new Categoria();
        categoria.setId(siguienteId++);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoria.setTipoProducto(tipoProducto);
        categorias.add(categoria);
    }

    // convertimos el modelo de la clase a dto
    private CategoriaDTO convertirModel(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        return categoriaDTO;
    }

    // buscamos categoria por su id y si no existe devolvemos null
    private Categoria buscarPorId(Integer id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)) {
                return categoria;
            }
        }
        return null;
    }

    // listamos las categorias
    public List<CategoriaDTO> listar() {
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasDTO.add(convertirModel(categoria));
        }
        return categoriasDTO;
    }

    // para ver si la categoria existe o no
    public boolean existeCategoria(Integer id) {
        return buscarPorId(id) != null;
    }

    // para ver una categoria y si no existe devolvemos null
    public CategoriaDTO verCategoria(Integer id) {
        Categoria existe = buscarPorId(id);
        if (existe == null) {
            return null;
        }
        return convertirModel(existe);
    }

    // comprobamos si ya existe una categoria con ese nombre
    public boolean nombreExiste(String nombre, Integer idNo) {
        for (Categoria categoria : categorias) {
            boolean nombreIgual = categoria.getNombre().equalsIgnoreCase(nombre);
            boolean nombreDiferente = idNo == null || !categoria.getId().equals(idNo);
            if (nombreIgual && nombreDiferente) {
                return true;
            }
        }
        return false;
    }

    // creamos la categoria
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setId(siguienteId++);
        nuevaCategoria.setNombre(categoriaDTO.getNombre());
        nuevaCategoria.setDescripcion(categoriaDTO.getDescripcion());
        categorias.add(nuevaCategoria);
        return convertirModel(nuevaCategoria);
    }

    // actualizamos la categoria
    public CategoriaDTO actualizarCategoria(Integer id, CategoriaDTO categoriaDTO) {
        Categoria existe = buscarPorId(id);
        if (existe == null) {
            return null;
        }
        existe.setNombre(categoriaDTO.getNombre());
        existe.setDescripcion(categoriaDTO.getDescripcion());
        return convertirModel(existe);
    }

    // eliminamos la categoria
    public boolean eliminarCategoria(Integer id) {
        Categoria existe = buscarPorId(id);
        if (existe == null) {
            return false;
        }
        categorias.remove(existe);
        return true;
    }
}
