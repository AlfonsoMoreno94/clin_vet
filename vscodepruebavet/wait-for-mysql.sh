#!/bin/sh
echo "⏳ Esperando a MySQL en $SPRING_DATASOURCE_URL..."

until nc -z prueba_jpa 3306; do
  echo "⌛ MySQL aún no está listo. Esperando 3s..."
  sleep 3
done

echo "✅ MySQL está disponible. Arrancando la aplicación..."
exec "$@"