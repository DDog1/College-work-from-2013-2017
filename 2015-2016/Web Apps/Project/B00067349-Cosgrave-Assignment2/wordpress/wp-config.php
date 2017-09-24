<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', '2006970_412f');

/** MySQL database username */
define('DB_USER', '2006970_412f');

/** MySQL database password */
define('DB_PASSWORD', 'LdvOrSHC');

/** MySQL hostname */
define('DB_HOST', 'fdb14.runhosting.com');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'DFq2uBV[Y=&DIU_-Ds2hA;tD[7CXabH>N7m-tG0vJrs?;0+}-MhL+G4/n8[0KEE|');
define('SECURE_AUTH_KEY',  'or^>I0p%)ak),CYT^Tv#1=]wZZ/<dVuE.m|o:GFi,a+*<Li.`A;nNJko+Fa$-wsb');
define('LOGGED_IN_KEY',    '8xVC0@PSSpNvhL$g8mq%|-4F)t}7F9)^R0e}7`4L6G>m(KHuoX]]jb,c![+-%=3c');
define('NONCE_KEY',        'Djz]!#!p t`-J&9Os3WAN.!!>P`Kc9%37&4H6NGWX#kp.SNd+-7Osh;vNVZ:i!e2');
define('AUTH_SALT',        'ST>Tu&L9$H`SAN2pXUA?c#TSizEw]AKA(REN5^^`Ql9;/%hSyryfj=w7|V`{|@im');
define('SECURE_AUTH_SALT', '?HDq+:$-+|e@cICjO%c/beRoatsJT$7c>mfxb)$PCznSmAy01E^35|Li9c4>9<tZ');
define('LOGGED_IN_SALT',   'NX~6x[GpNDe#j4-PcT/#1AyZwqX9+B^I>WmDfbIbwDBe-+7<t2ncoY-cZS3z2b<d');
define('NONCE_SALT',       'C~V y8IRsiNPb-tb#~>-bj$(rl7 HV.phT^mHfm]9t/7{dE~zdXh$R08PtKE7God');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
