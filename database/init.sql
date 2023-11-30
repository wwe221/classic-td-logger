-- CLEAR_INFO 클리어 할 때 저장되는 테이블
DROP TABLE IF EXISTS CLEAR_INFO;
CREATE TABLE CLEAR_INFO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id NVARCHAR(40),
    utc BIGINT,
    nick_name NVARCHAR(40),
    road_type SMALLINT,
    mode_type SMALLINT,
    difficult SMALLINT,
    point BIGINT,
    total_ingame_gold INT,
    tower_data TEXT,
    week INT,
    day INT,
    time timestamp default now()
);

-- GOLD_TABLE 골드 기록 테이블
DROP TABLE IF EXISTS GOLD_TABLE;
CREATE TABLE GOLD_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(40),
    flag SMALLINT,
    gold INT,
    time timestamp default now()
);

-- CLEAR_COUNT 클리어 횟수 기록 테이블
DROP TABLE IF EXISTS CLEAR_COUNT;
CREATE TABLE CLEAR_COUNT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(40),
    flag SMALLINT,
    count INT,
    time timestamp default now()
);

-- INGAME_STORE_BUY_INFO 일반 상점 구매 테이블
DROP TABLE IF EXISTS INGAME_STORE_BUY_INFO;
CREATE TABLE INGAME_STORE_BUY_INFO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    item_name VARCHAR(50),
    item_index INT,
    before_gold INT,
    use_gold INT,
    left_gold INT,
    buyed_info TEXT,
    time timestamp default now()

);

-- CASH_STORE_BUY_INFO 캐시 상점 구매 테이블
DROP TABLE IF EXISTS CASH_STORE_BUY_INFO;
CREATE TABLE CASH_STORE_BUY_INFO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    store_type INT,
    product_id VARCHAR(50),
    purchase_id VARCHAR(255),
    price INT,
    cash_item_name VARCHAR(50),
    cash_itemid VARCHAR(50),
    param0 VARCHAR(255),
    param1 VARCHAR(255),
    param2 VARCHAR(255),
    param3 VARCHAR(255),
    time timestamp default now()
);

-- FISHING_COUNT_TABLE 낚시 성공 횟수 테이블
DROP TABLE IF EXISTS FISHING_COUNT_TABLE;
CREATE TABLE FISHING_COUNT_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    time timestamp default now()
);

-- FISHING_GEAR_BUY_TABLE 낚시 장비 구매 테이블
DROP TABLE IF EXISTS FISHING_GEAR_BUY_TABLE;
CREATE TABLE FISHING_GEAR_BUY_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    gear_type INT,
    gear_index INT,
    before_gold INT,
    gear_price INT,
    time timestamp default now()
);

-- MINE_UPGRADE_TABLE 광산 업그레이드 테이블
DROP TABLE IF EXISTS MINE_UPGRADE_TABLE;
CREATE TABLE MINE_UPGRADE_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    mineral_index INT,
    before_level INT,
    after_level INT,
    mineral_data TEXT,
    time timestamp default now()
);

-- AWARD_BADGE_INFO 뱃지 테이블
DROP TABLE IF EXISTS AWARD_BADGE_INFO;
CREATE TABLE AWARD_BADGE_INFO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    badge_id VARCHAR(255),
    badge_name VARCHAR(255),
    param0 VARCHAR(255),
    param1 VARCHAR(255),
    param2 VARCHAR(255),
    param3 VARCHAR(255)
);

-- TOWER_DAMAGE_TABLE 타워 데미지 테이블
DROP TABLE IF EXISTS TOWER_DAMAGE_TABLE;
CREATE TABLE TOWER_DAMAGE_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    tower_index INT,
    damage BIGINT
);

-- TOWER_CREATE_COUNT_TABLE 타워 소환 횟수 테이블
DROP TABLE IF EXISTS TOWER_CREATE_COUNT_TABLE;
CREATE TABLE TOWER_CREATE_COUNT_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    version SMALLINT,
    flag SMALLINT,
    tower_index INT,
    create_count INT,
    UNIQUE KEY unique_version_flag_towerIndex (version, flag, tower_index)
);

-- CARDPACK_USE_COUNT_TABLE 카드팩 사용 기록 테이블
DROP TABLE IF EXISTS CARDPACK_USE_COUNT_TABLE;
CREATE TABLE CARDPACK_USE_COUNT_TABLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
  version SMALLINT,
    flag SMALLINT,
    user_id VARCHAR(40),
    utc BIGINT,
    nick_name VARCHAR(40),
    use_count INT,
    cardIndex0 INT,
    cardIndex1 INT,
    cardIndex2 INT,
    cardIndex3 INT,
    cardIndex4 INT
);
