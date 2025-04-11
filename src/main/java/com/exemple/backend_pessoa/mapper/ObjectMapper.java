package com.exemple.backend_pessoa.mapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapper {

    public static <T, U> U mapObject(T source, Class<U> targetClass, Map<String, String> fieldMapping) {
        try {
            U target = targetClass.getDeclaredConstructor().newInstance();
            Map<String, String> mapping = (fieldMapping != null) ? fieldMapping : new HashMap<>();

            Field[] sourceFields = source.getClass().getDeclaredFields();
            Field[] targetFields = targetClass.getDeclaredFields();

            for (Field sourceField : sourceFields) {
                sourceField.setAccessible(true);
                String sourceFieldName = sourceField.getName();
                String targetFieldName = mapping.getOrDefault(sourceFieldName, sourceFieldName);

                for (Field targetField : targetFields) {
                    targetField.setAccessible(true);
                    if (targetField.getName().equals(targetFieldName)) {
                        try {
                            Object value = sourceField.get(source);
                            targetField.set(target, value);
                            break; // Found the target field, move to the next source field
                        } catch (IllegalAccessException e) {
                            // Handle exception appropriately (log or throw)
                            e.printStackTrace();
                        }
                    }
                }
            }
            return target;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            // Handle exception appropriately (log or throw)
            e.printStackTrace();
            return null;
        }
    }

    public static <T, U> U mapObject(T source, Class<U> targetClass) {
        return mapObject(source, targetClass, null);
    }

    public static class UserEntity {
        private int id;
        private String name;
        private String email;

        public UserEntity() {}

        public UserEntity(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class UserDTO {
        private int userId;
        private String fullName;
        private String emailAddress;

        public UserDTO() {}

        public UserDTO(int userId, String fullName, String emailAddress) {
            this.userId = userId;
            this.fullName = fullName;
            this.emailAddress = emailAddress;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }
    }

    public static class ProductEntity {
        private int productId;
        private String description;
        private double price;

        public ProductEntity() {}

        public ProductEntity(int productId, String description, double price) {
            this.productId = productId;
            this.description = description;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class ProductDTO {
        private int productId;
        private String description;
        private double price;

        public ProductDTO() {}

        public ProductDTO(int productId, String description, double price) {
            this.productId = productId;
            this.description = description;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        // Mapeando de Entity para DTO
        UserEntity entity = new UserEntity(1, "John Doe", "john.doe@example.com");
        Class<UserDTO> dtoType = UserDTO.class;
        Map<String, String> fieldMappingEntityToDto = new HashMap<>();
        fieldMappingEntityToDto.put("id", "userId");
        fieldMappingEntityToDto.put("name", "fullName");
        fieldMappingEntityToDto.put("email", "emailAddress");
        UserDTO dto = ObjectMapper.mapObject(entity, dtoType, fieldMappingEntityToDto);
        System.out.println("DTO: userId=" + dto.getUserId() + ", fullName=" + dto.getFullName() + ", emailAddress=" + dto.getEmailAddress());

        // Mapeando de DTO para Entity
        UserDTO dtoInstance = new UserDTO(2, "Jane Smith", "jane.smith@example.com");
        Class<UserEntity> entityType = UserEntity.class;
        Map<String, String> fieldMappingDtoToEntity = new HashMap<>();
        fieldMappingDtoToEntity.put("userId", "id");
        fieldMappingDtoToEntity.put("fullName", "name");
        fieldMappingDtoToEntity.put("emailAddress", "email");
        UserEntity entityBack = ObjectMapper.mapObject(dtoInstance, entityType, fieldMappingDtoToEntity);
        System.out.println("Entity: id=" + entityBack.getId() + ", name=" + entityBack.getName() + ", email=" + entityBack.getEmail());

        // Mapeamento sem fieldMapping (campos com mesmo nome)
        ProductEntity productEntity = new ProductEntity(101, "Laptop", 1200.00);
        Class<ProductDTO> productDtoType = ProductDTO.class;
        ProductDTO productDto = ObjectMapper.mapObject(productEntity, productDtoType);
        System.out.println("Product DTO: productId=" + productDto.getProductId() + ", description=" + productDto.getDescription() + ", price=" + productDto.getPrice());
    }
}